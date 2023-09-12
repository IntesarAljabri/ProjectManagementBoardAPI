  <!-- //Get All Card // -->
    <script>
        var requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };

        fetch("http://localhost:8080/api/boards/1/cards", requestOptions)
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