let url="http://localhost:8080";
//get all card
        var requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch("url/api/boards/1/cards", requestOptions)
            .then(response => response.json())
            .then(result => {
                result.forEach(api => {

                    let sectitonId = api.section;
                    let boardDiv;

                    if (sectitonId === 1) {
                        boardDiv = document.getElementById("sectionToDo");
                    }
                    else if (sectitonId === 2) {
                        boardDiv = document.getElementById("sectionInProgress");
                    }
                    else {
                        boardDiv = document.getElementById("sectionDone");
                    }

                    let cardDiv = document.createElement("div");
                    cardDiv.className = "card";
                    cardDiv.id = "card" + api.id;

                    let idDiv = document.createElement("div");
                    idDiv.className = "idDiv";
                    idDiv.id = "id" + api.id;
                    idDiv.textContent = "#" + api.id;

                    let titleDiv = document.createElement("div");
                    titleDiv.className = "titleDiv";
                    titleDiv.id = "title-" + api.id;
                    titleDiv.textContent = api.title;

                    let descriptionDiv = document.createElement("div");
                    descriptionDiv.className = "descriptionDiv";
                    descriptionDiv.id = "description-" + api.id;
                    descriptionDiv.textContent = api.description;

                    cardDiv.appendChild(idDiv);
                    cardDiv.appendChild(titleDiv);
                    cardDiv.appendChild(descriptionDiv);

                    boardDiv.appendChild(cardDiv);



                    let deleteSelection = document.getElementById("deletesection");

                    let optionSelect = document.createElement("option");
                    optionSelect.id = "delete" + api.id;
                    optionSelect.textContent = api.id;

                    deleteSelection.appendChild(optionSelect);
                });
            })
            .catch(error => console.log('error', error));

        document.addEventListener("DOMContentLoaded", function () {
            let boardTitleElement = document.getElementById("boardTitle");

            var requestOptions = {
                method: 'GET',
                redirect: 'follow'
            };

            fetch("url/api/boards/1", requestOptions)
                .then(response => response.json())
                .then(result => boardTitleElement.textContent = result.title)
                .catch(error => console.log('error', error));
        });


/////////////////////////////////////////////////////////////////////////////////////////////////
//Update Board titel
function updateBoardTitle() {
    let updatedTitle = document.getElementById("newBoardTitle").value;
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "title": updatedTitle
    });

    var requestOptions = {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("url/api/boards/1", requestOptions)
        .then(response => response.text())
        .then(result => location.reload()
        )
        .catch(error => console.log('error', error));
}


/////////////////////////////////////////////////////////////////////////////////////////////
//Create new card
function createCard() {
    let cardTitle = document.getElementById("newTitle").value;
    let cardDescription = document.getElementById("newDescription").value;
    let cardSection = document.getElementById("newsection").value;
    console.log(cardTitle);

    document.getElementById("newsection").addEventListener("change", function () {
        cardSection = document.getElementById("newsection").value;
        console.log(cardSection);
    });

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "title": cardTitle,
        "description": cardDescription,
        "section": cardSection
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw
    };

    fetch("url/api/boards/1/cards", requestOptions)
        .then(response => response.json())
        .then(result => {
            console.log(result);
            location.reload();
        })
        .catch(error => console.log('error', error));
}



/////////////////////////////////////////////////////////////////////////////////
//Delete card

                function deleteCard() {
                    let deleteSelected = document.getElementById("deletesection").value;
                    var requestOptions = {
                        method: 'DELETE',
                        redirect: 'follow'
                    };

                    fetch("url/api/boards/1/cards/" + deleteSelected, requestOptions)
                        .then(response => response.text())
                        .then(result => {
                            console.log(result);
                            location.reload();
                        })
                        .catch(error => console.log('error', error));
                }
 
////////////////////////////////////////////////////////////////////////////////////////////
//Update Card

function UpdateCard() {
    let updatedId = document.getElementById("deletesection").value;
    
    let updatedTitle;
    if (document.getElementById("updateTitle").value === "") {
        updatedTitle = document.getElementById("title-" + updatedId).textContent;
    }
    else {
        updatedTitle = document.getElementById("updateTitle").value;
    }

    let updatedDescription;
    if (document.getElementById("updateDescription").value === "") {
        updatedDescription = document.getElementById("description-" + updatedId).textContent;
    }
    else {
        updatedDescription = document.getElementById("updateDescription").value;
    }

    let upadtedSection = document.getElementById("updateSection").value;

    document.getElementById("updateSection").addEventListener("change", function () {
        upadtedSection = document.getElementById("updateSection").value;
    });

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "title": updatedTitle,
        "description": updatedDescription,
        "section": upadtedSection
    });

    var requestOptions = {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("url/api/boards/1/cards/" + updatedId, requestOptions)
        .then(response => response.text())
        .then(result => {
            console.log(result);
            location.reload();
        })
        .catch(error => console.log('error', error));
}
              


