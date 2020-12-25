radioCreate = document.getElementById("radioCreate");
radioDelete = document.getElementById("radioDelete");
radioUpdate = document.getElementById("radioUpdate");

radioCreate.addEventListener('change', radioChanged);
radioDelete.addEventListener('change', radioChanged);
radioUpdate.addEventListener('change', radioChanged);

function radioChanged() {
    var radioValue = getRadioVal(document.getElementById('form1'), 'mode');

    var inputs = document.getElementsByTagName('input');

    for (var i = 0; i < inputs.length; i++) {
        input = inputs[i];
        if (input.type != "text") continue;
        if (input.id == "idinput") {
            if (radioValue != "create") {
                input.disabled = false;
            } else {
                input.disabled = true;
            }
        }
        if (input.id != "idinput") {
            if (radioValue == "delete") {
                input.disabled = true;
            } else {
                input.disabled = false;
            }
        }
    }
}

function getRadioVal(form, name) {
    var val;
    // get list of radio buttons with specified name
    radioCreate = document.getElementById("radioCreate");
    radioDelete = document.getElementById("radioDelete");
    radioUpdate = document.getElementById("radioUpdate");
    var radios = [radioCreate, radioDelete, radioUpdate];

    // loop through list of radio buttons
    for (var i = 0, len = radios.length; i < len; i++) {
        if (radios[i].checked) { // radio checked?
            val = radios[i].value; // if so, hold its value in val
            break; // and break out of for loop
        }
    }
    return val; // return value of checked radio or undefined if none checked
}
