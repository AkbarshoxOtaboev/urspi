$('document').ready(function (){
    $('.table .ebtn').on('click', function (event){
        event.preventDefault()
        let href = $(this).attr('href');
        $.get(href, function (structure, status){
            $('#structureId').val(structure.id)
            $('#editStructure').val(structure.name);
            $('#status').val(structure.status)
        });
        $('#editStructureModal').modal();
    });
});