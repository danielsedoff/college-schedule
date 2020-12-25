var radioCreate = document.getElementById("radioCreate");
var radioDelete = document.getElementById("radioDelete");
var radioUpdate = document.getElementById("radioUpdate");

var radios = [radioCreate, radioDelete, radioUpdate];

radioCreate.addEventListener('change', radioChanged);
radioDelete.addEventListener('change', radioChanged);
radioUpdate.addEventListener('change', radioChanged);

function radioChanged() {
    var radioValue = getRadioVal(radios);
    var entityname = document.getElementById("entityname").value;
    document.getElementById("form1").action = radioValue + capitalizeFirstLetter(entityname);

    var inputs = document.getElementsByTagName('input');

    for (var i = 0; i < inputs.length; i++) {
        input = inputs[i];
        if (input.type != "text" && input.type != "number") continue;
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

function getRadioVal(radios) {
    for (var i = 0, len = radios.length; i < len; i++) {
        if (radios[i].checked) {
            return radios[i].value;
        }
    }
}

function capitalizeFirstLetter(string) {
  return string.charAt(0).toUpperCase() + string.slice(1);
}
radioChanged();
