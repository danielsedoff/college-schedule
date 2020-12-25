radCreate = document.getElementById("radioCreate");
radDelete = document.getElementById("radioDelete");
radUpdate = document.getElementById("radioUpdate");

radCreate.addEventListener('change', function(){
    alert('create: ' + this.value);
})

radDelete.addEventListener('change', function(){
    alert('delete: ' + this.value);
})

radUpdate.addEventListener('change', function(){
    alert('update: ' + this.value);
})
