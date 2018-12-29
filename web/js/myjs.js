$(function () {
    $("#release").click(function () {
        var user = $("#showuser").text();
        if(user == null || user == ""){
            $("#loginModal").modal();
        }else {
            window.location.href="/article/release";
        }
    });

    $(".deleteArticle").click(function () {
        var $parent = $(this).parent().parent();
        var title = $parent.find("h4").text();
        var id = $parent.find("span").text();
        var confirm1 = confirm("确认删除" + title + "吗?");

        if(confirm1){
            var delhref ="/article/delete/" + id;
            $.post(delhref, function () {
                window.location.reload();
            });
        }
    });
});