package dev.mitingi.products

data class DataResponse(
    var data:List<Data>,
    var total:Int,
    var skip:Int,
    var limit:Int,
) {

