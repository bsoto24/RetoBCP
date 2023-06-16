package pe.com.test.ui.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * Paginator
 *
 * @author Bryam Soto
 * @since 16/06/23
 */
abstract class Paginator(
    private var layoutManager: LinearLayoutManager
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItems = layoutManager.childCount
        val totalItems = layoutManager.itemCount
        val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()

        if (!isLoading() && hasNext()) {
            if ((visibleItems + firstVisiblePosition) >= totalItems && firstVisiblePosition >= 0 && totalItems >= 2) {
                loadMoreItems()
            }
        }

    }

    abstract fun hasNext(): Boolean
    abstract fun isLoading(): Boolean
    abstract fun loadMoreItems()

}