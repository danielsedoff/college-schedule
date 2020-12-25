function g(what) { return document.getElementById(what) }

/*

Нужно написать парсер для формата:
    yyyy-MM-dd HH:mm 
в обе стороны.
Чтобы собиралось с сервера и уходило на сервер в этом формате.
При загрузке пустой страницы (CREATE) шаблон должен быть прописан на странице.

Скрипт должен отказывать юзеру при попытке дать не тот формат
(для этого можно использовать регекс)

*/

function fillStartDate(){
    format = "yyyy-MM-dd HH:mm"
    
    source1 = g("startDateRaw");
    source2 = g("startTimeRaw");
    target = g("startTime");
    
    
}