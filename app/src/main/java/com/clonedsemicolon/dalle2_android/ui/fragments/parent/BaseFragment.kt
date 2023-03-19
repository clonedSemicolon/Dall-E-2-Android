package com.inverse.core.newBaseClasses

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<V : ViewBinding>(private val inflater: Inflate<V>) : Fragment() {
    protected var binding: V? =null
    var idTag: String = ""
        get() = if (field == null) javaClass.simpleName else field

    override fun onCreateView(inflaterp: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = inflater.invoke(inflaterp, container, false)
        return binding!!.root
    }

    abstract fun initView()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    protected inline fun <reified T> grabListener():T? {
        var par = parentFragment
        while (par != null) {
            if (par is T) {
                return par
            }
            par = par.parentFragment
        }
        if (activity is T) return (activity as T)
        return null
    }

    var lastFragmentTag = ""
    fun loadFragment(
        newFragment: Fragment,
        containerId: Int,
        addToBackStack: Boolean = true,
        clearBackStack: Boolean = false,
        replacePrev: Boolean = false,
        animate: Boolean = true,
        TAG: String? = tag
    ) {
        try {
            if (lastFragmentTag == newFragment.javaClass.simpleName) {
                return
            }
            lastFragmentTag = newFragment.javaClass.simpleName
            handleDoubleClick()
            val mFragmentManager: FragmentManager = childFragmentManager
            if (clearBackStack) {
                if (mFragmentManager.isStateSaved) {
                    return
                }
                mFragmentManager.popBackStackImmediate(
                    null,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
            }
            val fragmentTransaction =
                mFragmentManager.beginTransaction()
            if (addToBackStack) fragmentTransaction.addToBackStack(tag)
            if (replacePrev) {
                fragmentTransaction.replace(
                    containerId,
                    newFragment,
                    TAG
                )
            } else {
                fragmentTransaction.add(
                    containerId,
                    newFragment,
                    TAG
                )
            }

            if (mFragmentManager.isStateSaved) {
                fragmentTransaction.commitAllowingStateLoss()
            } else {
                fragmentTransaction.commit()
            }
        } catch (ex: Exception) { }
    }

    private fun handleDoubleClick() {
        Handler(Looper.getMainLooper()).postDelayed({ lastFragmentTag = "" }, 500)
    }

    fun popFragment(fragmentManager: FragmentManager = parentFragmentManager) {
        try {
            fragmentManager.popBackStack()
        } catch (ex: Exception) { }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}