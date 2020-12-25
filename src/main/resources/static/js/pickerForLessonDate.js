function pickerForLessonDate(inputId) {
    var input = document.getElementById(inputId);
    var picker = new Picker(input, {
        format: 'YYYY-MM-DD HH:mm',
    });
    picker.show();
}