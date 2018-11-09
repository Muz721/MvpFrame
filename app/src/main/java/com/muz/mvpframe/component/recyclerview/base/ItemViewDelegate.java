package com.muz.mvpframe.component.recyclerview.base;


/**
 * @description  
 * @author  Muz
 * @date  2018/10/24 15:16
 */
public interface ItemViewDelegate<T>
{

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}
