function saveGrade(gradeEl) {
    let gradeInput = $(gradeEl);
    let gradeDto = new Object();
    gradeDto.subjectId = gradeInput.attr("subject-id");
    gradeDto.studentId = gradeInput.attr("student-id");
    gradeDto.dateTime = gradeInput.attr("date-time");
    gradeDto.value = gradeInput.children().val();
    if(gradeInput.children().attr("value")){
        gradeDto.id = gradeInput.attr("grade-id");
        $.ajax({
            type: "PUT",
            url: "/api/grade",
            data: JSON.stringify(gradeDto),
            success:  function( data ) {
                console.log(data);
            },
            dataType: "json",
            contentType:"application/json; charset=utf-8"
        });
    }else {
        gradeDto.id = null;
        $.ajax({
            type: "POST",
            url: "/api/grade",
            data: JSON.stringify(gradeDto),
            success:  function( data ) {
                console.log(data);
            },
            dataType: "json",
            contentType:"application/json; charset=utf-8"
        });
    }
}