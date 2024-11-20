$('document').ready(function (){
    $('.table .ebtn').on('click', function (event){
        event.preventDefault()
        let href = $(this).attr('href');
        $.get(href, function (menu, status){
            $('#menuId').val(menu.id)
            $('#menu_edit_name').val(menu.name);
            $('#page_edit_type').val(menu.pageType)
        });
        $('#editMenuModal').modal();
    });
});