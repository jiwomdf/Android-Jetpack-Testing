package com.programmergabut.android_jetpack_testing.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.programmergabut.android_jetpack_testing.adapter.ImageAdapter
import com.programmergabut.android_jetpack_testing.adapter.ShoppingItemAdapter
import com.programmergabut.android_jetpack_testing.repositories.FakeShoppingRepositoryAndroid
import javax.inject.Inject

class TestShoppingFragmentFactory @Inject constructor(
    private val imageAdapter: ImageAdapter,
    private val glide: RequestManager,
    private val shoppingItemAdapter: ShoppingItemAdapter
): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ImagePickFragment::class.java.name -> ImagePickFragment(imageAdapter)
            AddShoppingItemFragment::class.java.name -> AddShoppingItemFragment(glide)
            ShoppingFragment::class.java.name -> ShoppingFragment(
                shoppingItemAdapter,
                ShoppingViewModel(FakeShoppingRepositoryAndroid())
            )
            else -> super.instantiate(classLoader, className)
        }
    }
}