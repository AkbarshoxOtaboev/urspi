$('document').ready(function (){
    $('.table .ebtn').on('click', function (event){
        event.preventDefault()
        let href = $(this).attr('href');
        $.get(href, function (positions, status){
            $('#positionId').val(positions.id)
            $('#edit_position_name').val(positions.name);
            $('#status').val(positions.status)
        });
        $('#editPositionModal').modal();
    });
});