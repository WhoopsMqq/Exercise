layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#productList',
        url : '/web/product/getAllProducts',
        cellMinWidth : 95,
        height : "full-125",
        id : "productListTable",
        cols : [[
            {field: 'id', title: 'ID', width:60, align:"center"},
            {field: 'name', title: '名称', width:350},
            {field: 'price', title: '价格', align:'center'}
        ]]
    });
    
    $(".foreign").on("click",function(){
        table.reload('productListTable',{
            where:{
                type:'foreign'
            }
        });
    })

    $(".domestic").on("click",function(){
        table.reload('productListTable',{
            where:{
                type:'domestic'
            }
        });
    })




})