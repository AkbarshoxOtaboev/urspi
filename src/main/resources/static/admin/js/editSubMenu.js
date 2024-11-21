$('document').ready(function (){
    $('.table .ebtn').on('click', function (event){
        event.preventDefault()
        let href = $(this).attr('href');
        $.get(href, function (subMenu, status){
            $('#id').val(subMenu.id)
            $('#editSubMenuName').val(subMenu.subMenuName);
        });
        $('#editMenuModal').modal();
    });
});