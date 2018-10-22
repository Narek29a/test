$(document).ready(function () {
    $("#but").click(function () {
        let path = $("#path").val();
        $("#basePath").text(path);
        $.post("http://localhost:8080/getFiles",{"path": path}, function (data) {
                $("#files").html('');
                data.map(item => {
                    $("#files").append(item + "<br>");

                });
            })
    })


});