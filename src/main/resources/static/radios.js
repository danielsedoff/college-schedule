radioCreate = document.getElementById("radioCreate");
radioDelete = document.getElementById("radioDelete");
radioUpdate = document.getElementById("radioUpdate");

radioCreate.addEventListener('change', radioChanged);
radioDelete.addEventListener('change', radioChanged);
radioUpdate.addEventListener('change', radioChanged);

function radioChanged() {
    if (document.getElementById("radioCreate").checked) {
        radioValue = "create";
    } else if (document.getElementById("radioDelete").checked) {
        radioValue = "delete";
    } else if (document.getElementById("radioUpdate").checked) {
        radioValue = "update";
    }

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
