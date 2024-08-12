$('document').ready(function (){
    $('.table .ebtn').on('click', function (event){
        event.preventDefault()
        let href = $(this).attr('href');
        $.get(href, function (department, status){
            $('#departmentId').val(department.id)
            $('#edit_department_name').val(department.name);
            $('#status').val(department.status)
        });
        $('#editDepartmentModal').modal();
    });
});