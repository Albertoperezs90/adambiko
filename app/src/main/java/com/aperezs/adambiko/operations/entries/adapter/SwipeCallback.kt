package com.aperezs.adambiko.operations.entries.adapter

import android.graphics.Canvas
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


class SwipeCallback(
    private val onDelete: (position: Int) -> Unit,
    private val onRead: (position: Int) -> Unit
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.RIGHT) onDelete(viewHolder.adapterPosition) else onRead(viewHolder.adapterPosition)
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        viewHolder?.let { ItemTouchHelper.Callback.getDefaultUIUtil().onSelected(getForegroundView(viewHolder = it)) }
    }

    override fun onChildDrawOver(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder?, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        ItemTouchHelper.Callback.getDefaultUIUtil().onDrawOver(c, recyclerView, getForegroundView(viewHolder), dX, dY, actionState, isCurrentlyActive)
    }

    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        val deletedBackground = (viewHolder as EntriesAdapter.ViewHolder).binding.viewDeleteBackground
        val readedBackground = (viewHolder).binding.viewReadBackground

        if (isSwipingToRight(dX) && readedBackground.visibility == VISIBLE) {
            deletedBackground.visibility = VISIBLE
            readedBackground.visibility = INVISIBLE
        } else if (isSwipingToLeft(dX) && deletedBackground.visibility == VISIBLE) {
            deletedBackground.visibility = INVISIBLE
            readedBackground.visibility = VISIBLE
        }

        ItemTouchHelper.Callback.getDefaultUIUtil().onDraw(c, recyclerView, getForegroundView(viewHolder), dX, dY, actionState, isCurrentlyActive)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        ItemTouchHelper.Callback.getDefaultUIUtil().clearView(getForegroundView(viewHolder = viewHolder))
    }

    override fun getSwipeDirs(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        val entry = (viewHolder as EntriesAdapter.ViewHolder).binding.entry
        return if (entry != null && entry.isDisabled) 0 else super.getSwipeDirs(recyclerView, viewHolder)
    }


    private fun isSwipingToRight(dX: Float) = dX > 0
    private fun isSwipingToLeft(dX: Float) = dX < 0

    private fun getForegroundView(viewHolder: RecyclerView.ViewHolder?): View {
        return (viewHolder as EntriesAdapter.ViewHolder).binding.viewForeground
    }

}