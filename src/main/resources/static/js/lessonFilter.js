function clearLessonFilter() {
	gbi = x => document.getElementById(x);
	inputYear = gbi("inputYear").value;
	inputMonth = gbi("inputMonth").value;
	inputYear.value = "";
	inputMonth.value = "";
	lessonFilter(true, 0, 0);
}

function runLessonFilter() {
	gbi = x => document.getElementById(x);
	inputYear = gbi("inputYear").value;
	inputMonth = gbi("inputMonth").value;
	lessonFilter(false, inputYear, inputMonth);
}

function lessonFilter(clearFilter, filterYear, filterMonth) {

	validYear = (filterYear > 1 && filterYear < 9000);
	validMonth = (filterMonth > 0 && filterMonth < 12);
	
	filterYear = filterYear / 1;
	filterMonth = filterMonth / 1;

	allTrs = document.getElementsByTagName("tr");
	for (i = 0; i < allTrs.length; i++) {
		certainTr = allTrs[i];

		if (clearFilter === true) {
			certainTr.style.display = "";
			continue;
		}

		textContent = certainTr.children[1].textContent;
		givenData = textContent.split("-");
		givenYear = givenData[0] / 1;
		givenMonth = givenData[1] / 1;
		
		if ((isNaN(givenYear) || givenYear < 0 || givenYear > 9000) ||
			/* Not a year */
		   (isNaN(givenMonth) || givenMonth < 1 || givenMonth > 12)) {
			/* Not a month */
			continue; 
		}

		if ((validMonth && givenMonth != filterMonth) || 
		    (validYear  && givenYear  != filterYear)) {
			certainTr.style.display = "none";
		} else {
			certainTr.style.display = "";
		}
	}
}
