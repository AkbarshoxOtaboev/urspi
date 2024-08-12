$('document').ready(function (){
    $('.table .ebtn').on('click', function (event){
        event.preventDefault()
        let href = $(this).attr('href');
        $.get(href, function (category, status){
            $('#categoryId').val(category.id)
            $('#edit_category_name').val(category.name);
            $('#status').val(category.status)
        });
        $('#editCategoryModal').modal();
    });
});