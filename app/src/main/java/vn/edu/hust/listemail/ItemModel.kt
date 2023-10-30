package vn.edu.hust.listemail

data class ItemModel(val name: String, val title: String, val content: String, val time: String, val avatar: Int = 0) {
    var selected: Boolean = false
}