function submitter() {
    var send = document.getElementById("submitterResult");
    
    radioValue = "";
    if (document.getElementById("radioCreate").checked) {
        radioValue = "create";
    } else if (document.getElementById("radioDelete").checked) {
        radioValue = "delete";
    } else if (document.getElementById("radioUpdate").checked) {
        radioValue = "update";
    }
    
    postText = "mode=" + radioValue + "&";
    var inputs = document.getElementsByTagName('input');
    for (var i = 0; i < inputs.length; i++) {
        input = inputs[i];
        if (input.type != "text") continue;
        postText += input.name + "=" + input.value + "&"
    }
    postText += "end; \n";
    var xhr = new XMLHttpRequest();

    var postMsg = 'encoded=' + encodeURIComponent(postText);

    xhr.open("POST", "/college-schedule/courseEdit", true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhr.onreadystatechange = function() { // (3)
        if (xhr.readyState != 4) return;

        send.innerHTML = 'Sending...';

        if (xhr.status != 200) {
            send.innerHTML = xhr.status + ': ' + xhr.statusText;
        } else {
            send.innerHTML = xhr.responseText;
            if (send.innerHTML.indexOf("Success") != -1) {
                send.style.backgroundColor = "yellow";
            }
        }

    }

    xhr.send(postMsg);
}