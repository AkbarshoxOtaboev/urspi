$('document').ready(function (){
    $('.table .ebtn').on('click', function (event){
        event.preventDefault()
        let href = $(this).attr('href');
        $.get(href, function (event, status){
            $('#eventId').val(event.id)
            $('#edit_event_title').val(event.title);
            $('#edit_event_description').val(event.description)
            $('#status').val(event.status)
        });
        $('#editEventModal').modal();
    });
});