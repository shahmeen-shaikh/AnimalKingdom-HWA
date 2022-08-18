"use strict";

//Divs
let resultsDiv = document.querySelector("#results-div");

//Inputs
let nameInput = document.querySelector("#nameInput");
let genusInput = document.querySelector("#genusInput");
let dietaryGroupInput = document.querySelector("#dietaryGroupInput");
let ageInput = document.querySelector("#ageInput");
let idInput = document.querySelector("#idInput");


//Buttons
let createBtn = document.querySelector("#createBtn");
let updateBtn = document.querySelector("#updateBtn");
let deleteBtn = document.querySelector("#deleteBtn");

//Functions

let printResults = (result) => {
    let entryParent = document.createElement("div");
    entryParent.setAttribute("class", "entry-parent");

    let entryDiv = document.createElement("div");
    entryDiv.setAttribute("class", "entry-div");
    entryDiv.textContent =`${result.id} | ${result.name} | ${result.genus} | ${result.dietaryGroup} | ${result.age}`;

    let delBtn = document.createElement("button");
    delBtn.textContent = "Delete";
    delBtn.type = "button";
    delBtn.setAttribute("Class", "btn btn-danger btn-sm");
    delBtn.setAttribute("onClick", `del(${result.id})`);

    entryParent.appendChild(entryDiv);
    entryParent.appendChild(delBtn);
    resultsDiv.appendChild(entryParent);
}

let getAll = () => {
    axios.get("http://localhost:8080/animal/getAll")

    .then(res => {
        resultsDiv.innerHTML = "";
        let results = res.data;

        for (let result of results) {
            printResults(result);
        }
        }
    )
    .catch(err => {
        console.log(err);
       }
    );
}


let create = () => {
    
    let obj = {
        "name": nameInput.value,
        "genus": genusInput.value,
        "dietaryGroup": dietaryGroupInput.value,
        "age": ageInput.value
    }

    axios.post("http://localhost:8080/animal/create", obj)
    .then( res => {
        getAll();
    }
    )
    .catch(err => {
            console.log(err);
           }
    );

}


let update = () => {

    let obj = {
        "name": nameInput.value,
        "genus": genusInput.value,
        "dietaryGroup": dietaryGroupInput.value,
        "age": ageInput.value
    }
    
    axios.put(`http://localhost:8080/animal/update/${idInput.value}`, obj)
        .then((resp) => {
            getAll();
        }).catch((err) => {console.error(err);})
}


let del = (id) => {

    // if (!validateDelete()) {
    //     return;
    // }

    axios.delete(`http://localhost:8080/animal/delete/${id}`)
        .then((resp) => {
            getAll();
        }).catch((err) => {console.log(err);})
}

let validateDelete = () => {
    if (idInput.value === "") {
        alert("ID is required for this operation");
        return false;
    } else {
        return true;
    }
}
//listeners
createBtn.addEventListener("click",create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del)