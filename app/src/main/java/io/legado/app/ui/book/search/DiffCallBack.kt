package io.legado.app.ui.book.search

import androidx.recyclerview.widget.DiffUtil

class DiffCallBack : DiffUtil.ItemCallback<SearchEntity>() {
    override fun areItemsTheSame(oldItem: SearchEntity, newItem: SearchEntity): Boolean {
        return oldItem.name == newItem.name
                && oldItem.author == newItem.author
    }

    override fun areContentsTheSame(oldItem: SearchEntity, newItem: SearchEntity): Boolean {
        return oldItem.originCount == newItem.originCount
                && (oldItem.coverUrl == newItem.coverUrl || !oldItem.coverUrl.isNullOrEmpty())
                && (oldItem.kind == newItem.kind || !oldItem.kind.isNullOrEmpty())
                && (oldItem.latestChapterTitle == newItem.latestChapterTitle || !oldItem.kind.isNullOrEmpty())
                && oldItem.intro?.length ?: 0 > newItem.intro?.length ?: 0
    }

    override fun getChangePayload(oldItem: SearchEntity, newItem: SearchEntity): Any? {
        return when {
            oldItem.originCount != newItem.originCount -> 1
            oldItem.coverUrl != newItem.coverUrl -> 2
            oldItem.kind != newItem.kind -> 3
            oldItem.latestChapterTitle != newItem.latestChapterTitle -> 4
            oldItem.intro != newItem.intro -> 5
            else -> null
        }
    }
}