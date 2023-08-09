
 function getCards() {
            var requestOptions = {
                method: 'GET',
                redirect: 'follow'
            };

            fetch("http://localhost:8080/api/boards/1/cards", requestOptions)
                .then(response => response.json())
                .then(parsedResponse => {
                    parsedResponse.forEach(element => {

                        let boardDiv;

                        let sectionDiv = element.section;

                        if (sectionDiv === 1) {
                            boardDiv = document.getElementById("ToDo");
                        }
                        else if (sectionDiv === 2) {
                            boardDiv = document.getElementById("InProgress");
                        }
                        else {
                            boardDiv = document.getElementById("Done");
                        }

                        let cardDiv = document.createElement("div");
                        cardDiv.className = "card";
                        

                        let idDiv = document.createElement("div");
                        idDiv.className = "card-id";
                        idDiv.textContent = "#" + element.id; // Set the text content here

                        let cardTitleDiv = document.createElement("div");
                        cardTitleDiv.className = "card-title";
                        cardTitleDiv.textContent = element.title; // Set the text content here

                        let descriptionDiv = document.createElement("div");
                        descriptionDiv.className = "card-description";
                        descriptionDiv.textContent = element.description; // Set the text content here
                        cardDiv.appendChild(idDiv);
                        cardDiv.appendChild(cardTitleDiv);
                        cardDiv.appendChild(descriptionDiv);
                        cardDiv.appendChild(goCornner);

                        boardDiv.appendChild(cardDiv);
                    });
                })
                .catch(error => console.log('error', error));
        }

        window.onload = getCards;

        function handledropdownUpdateItemClick(sectionValueUpadte) {
            selectedSectionUpdate = sectionValueUpadte;
            document.getElementById("dropdownMenuButtonUpdate").textContent = "Section " + selectedSectionUpdate; // Update the button text to reflect the selected section
        }

        let cardId;
        fetch("http://localhost:8080/api/boards/1/cards")
            .then((response) => { return response.json() })
            .then((parsedResponse) => {
                let dropdownMenuDiv = document.getElementById("dropdownMenu2");

                parsedResponse.forEach((element) => {
                    let dropdownItem = document.createElement("a");
                    dropdownItem.className = "cardDropdown";
                    dropdownItem.textContent = element.id;
                    dropdownItem.setAttribute("data-id", element.id);
                    dropdownMenuDiv.appendChild(dropdownItem);

                    dropdownItem.addEventListener("click", function () {
                        cardId = this.getAttribute("data-id");
                        document.getElementById("dropdownMenuButton2").innerHTML = "Card " + cardId;
                    });
                });
            })
            .catch((error) => {
                console.error("Error fetching data:", error);
            });


 ////////////////////////////////////////////////////////////////////////////////////////
            function deleteData() {
                const cardDropdown = document.getElementById("cardDropdown");
                const selectedCardId = cardDropdown.value;
            
                const url = "http://localhost:8080/api/boards/1/cards/" + selectedCardId;
            
                const options = {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                };
            
                fetch(url, options)
                    .then(response => {
                        if (response.ok) {
                            console.log('Card deleted successfully!');
                            location.reload();
                        } else {
                            console.error('Error deleting card:', response.statusText);
                        }
                    })
                    .catch(error => {
                        console.error('Error:', error);
                    });
            }
////////////////////////////////////////////////////////////////////////////

    function updateCard() {
                let cardTitleUpdate = document.getElementById("updateTitle").value;
                let cardDescriptionUpdate = document.getElementById("updateDescription").value;

                var myHeaders = new Headers();
                myHeaders.append("Content-Type", "application/json");

                var raw = JSON.stringify({
                    "title": cardTitleUpdate,
                    "description": cardDescriptionUpdate,
                    "section": selectedSectionUpdate
                });

                var requestOptions = {
                    method: 'PUT',
                    headers: myHeaders,
                    body: raw,
                    redirect: 'follow'
                };

                fetch("http://localhost:8080/api/boards/1/cards/" + cardId, requestOptions)
                    .then(response => response.text())
                    .then(result => {
                        console.log(result);
                        location.reload(); // Reload after update is complete
                    })
                    .catch(error => console.log('error', error));
            }

            // Example event listener for section updates
            document.getElementById("section1-update").addEventListener("click", () => handledropdownUpdateItemClick(1));
            document.getElementById("section2-update").addEventListener("click", () => handledropdownUpdateItemClick(2));
            document.getElementById("section3-update").addEventListener("click", () => handledropdownUpdateItemClick(3));
    function createCard() {
            let Title = document.getElementById("enterTitleCard").value;
            let cardDescription = document.getElementById("enterDescriptionCard").value;

            // Validate cardTitle, cardDescription, and selectedSection here if needed

            var myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json");

            var raw = JSON.stringify({
                "title": cardTitle,
                "description": cardDescription,
                "section": selectedSection
            });

            var requestOptions = {
                method: 'POST',
                headers: myHeaders,
                body: raw,
                redirect: 'follow'
            };

            fetch("http://localhost:8080/api/boards/1/cards", requestOptions)
                .then(response => response.json())
                .then(result => {
                    console.log(result);
                    location.reload();
                })
                .catch(error => console.log('error', error));
            location.reload();
        }


        // Add event listeners to dropdown items and update selected section on click
        document.getElementById("section1").addEventListener("click", () => handleDropdownItemClick(1));
        document.getElementById("section2").addEventListener("click", () => handleDropdownItemClick(2));
        document.getElementById("section3").addEventListener("click", () => handleDropdownItemClick(3));
  
        // Function to fetch the titles from the API
        function getTitlesFromAPI() {

            var requestOptions = {
                method: 'GET',
                redirect: 'follow'
            };

            fetch("http://localhost:8080/api/boards", requestOptions)
                .then((response) => { return response.json() })
                .then(
                    (parsedResponse) => {

                        parsedResponse.forEach(element => {
                            let titleDiv = document.getElementById("main-title");
                            titleDiv.innerHTML = element.title;
                        });
                    }
                )
                .catch(error => console.log('error', error));
        }

        window.addEventListener("load", function () {
            getTitlesFromAPI();
        });


///////////////////////////////////////////////////////////////////////////
// Function to update the main title
function updateTitle() {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const titleValue = document.getElementById('search').value;

    var raw = JSON.stringify({
        "title": titleValue
    });

    var requestOptions = {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
    };

    fetch("http://localhost:8080/api/boards/1", requestOptions)
        .then(response => response.json())
        .then(result => {
            console.log(result);
            const newTitle = titleValue.trim();
            if (newTitle !== "") {
                document.getElementById("main-title").textContent = newTitle;
            }
        })
        .catch(error => console.log('error', error));
}

// Function to update the selected section
function handleDropdownUpdateItemClick(sectionValue) {
    selectedSectionUpdate = sectionValue;
    document.getElementById("dropdownMenuButtonUpdate").textContent = "Section " + selectedSectionUpdate;
}

// Function to fetch cards and display them on the board
function getCards() {
    // ... your getCards function here ...
}

window.onload = function () {
    getCards();

    // Event listeners for section updates
    document.getElementById("section1-update").addEventListener("click", () => handleDropdownUpdateItemClick(1));
    document.getElementById("section2-update").addEventListener("click", () => handleDropdownUpdateItemClick(2));
    document.getElementById("section3-update").addEventListener("click", () => handleDropdownUpdateItemClick(3));
};

       // Function to update the main title
        function updateTitle() {
            var myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json");

            const titleValue = document.getElementById('search').value; // Use 'search' instead of 'input-title'

            var raw = JSON.stringify({
                "title": titleValue
            });

            var requestOptions = {
                method: 'PUT',
                headers: myHeaders,
                body: raw,
            };

            fetch("http://localhost:8080/api/boards/1", requestOptions)
                .then(response => response.json())
                .then(result => {
                    console.log(result);
                    const newTitle = titleValue.trim();
                    if (newTitle !== "") {
                        document.getElementById("main-title").textContent = newTitle;
                    }
                })
                .catch(error => console.log('error', error));
        }

        // Update the event listener in the HTML form to match the function name
        <button id="submit" type="button" class="btn btn-primary" onclick="updateTitle()">Update</button>
        document.getElementById("section1-update").addEventListener("click", () => handleDropdownItemClick(1));
        document.getElementById("section2-update").addEventListener("click", () => handleDropdownItemClick(2));
        document.getElementById("section3-update").addEventListener("click", () => handleDropdownItemClick(3));

                // // Event listener for the "SET" button click
                setButton.addEventListener("click", function () {
                    upadteTitle();
                    // Get the value from the input text box
                    const newTitle = inputTitle.value.trim();

                    // Update the main title with the new value
                    if (newTitle !== "") {
                        mainTitle.textContent = newTitle;
                    }
            });