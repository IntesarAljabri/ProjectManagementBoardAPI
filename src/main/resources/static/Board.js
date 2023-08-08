/////////////////////////////////////////////////////////////////////
/* Update title*/
document.addEventListener("DOMContentLoaded", function() {
    var updateForm = document.getElementById("updateForm");
    var searchInput = document.getElementById("search");

    updateForm.addEventListener("submit", function(event) {
        event.preventDefault();

        var newTitle = searchInput.value;

        // Perform any necessary actions with the new title
        // For example, you can update the section automatically
        var newSection = updateSectionAutomatically(newTitle);

        console.log("New Title:", newTitle);
        console.log("New Section:", newSection);
        
        // Optionally, you can update the UI or perform other actions here
    });

    function updateSectionAutomatically(title) {
        // Logic to determine and return the new section based on the title
        // Replace this with your actual logic
        return "Updated Section";
    }
});

////////////////////////////////////////////////////////////////////////////
/* get all Cards*/
// Function to get all cards
function getAllCards() {
    fetch("http://localhost:8080/api/card/getAll")
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch cards");
            }
            return response.json();
        })
        .then(cards => {
            // Process the fetched cards
            // You can iterate through the 'cards' array and do something with each card
            console.log(cards);
        })
        .catch(error => {
            console.error("Error:", error);
        });
}

// Call the function to fetch all cards
getAllCards();


////////////////////////////////////////////////////////////////////////////////
/* get Card by Id */

// Function to get a card by ID
function getCardById(cardId) {
    fetch(`http://localhost:8080/api/card/getById?id=${cardId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch card");
            }
            return response.json();
        })
        .then(card => {
            // Process the fetched card
            console.log(card);
        })
        .catch(error => {
            console.error("Error:", error);
        });
}

const cardIdToFetch = 123; // Replace with the actual card ID you want to fetch
getCardById(cardIdToFetch);



//////////////////////////////////////////////////////////////////////////
/*Create new Card*/

function createCard() {
    var addCardForm = document.getElementById("addCardForm");
    var cardsContainer = document.getElementById("cardsContainer");

    addCardForm.addEventListener("submit", function(event) {
        event.preventDefault();

        var titleInput = document.getElementById("newTitle").value;
        var descriptionInput = document.getElementById("newDescription").value;
        var sectionInput = document.getElementById("newSection").value;

        var newCard = {
            title: titleInput,
            description: descriptionInput,
            section: sectionInput
        };

        // Create a new card element and add it to the cards container
        var cardElement = document.createElement("div");
        cardElement.className = "card";
        cardElement.innerHTML = "<h3>" + newCard.title + "</h3><p>" + newCard.description + "</p>";
        cardsContainer.appendChild(cardElement);

        // Clear the form inputs
        addCardForm.reset();
    });
}

createCard(); // Call the function to set up the form submission handling



///////////////////////////////////////////////////////////////////////////////////////////////////////
/*Delete Card */

function deleteCard(cardId) {
    var cardToDelete = document.getElementById("card-" + cardId);
    if (cardToDelete) {
        cardToDelete.remove();
    }
}

document.addEventListener("DOMContentLoaded", function() {
    var addCardForm = document.getElementById("addCardForm");
    var cardDropdown = document.getElementById("cardDropdown");

    addCardForm.addEventListener("submit", function(event) {
        event.preventDefault();

        var titleInput = document.getElementById("newTitle").value;
        var descriptionInput = document.getElementById("newDescription").value;
        var sectionInput = document.getElementById("newSection").value;

        var newCard = {
            title: titleInput,
            description: descriptionInput,
            section: sectionInput
        };

        var cardElement = document.createElement("div");
        cardElement.className = "card";
        cardElement.id = "card-" + cardDropdown.value;
        cardElement.innerHTML = "<h3>" + newCard.title + "</h3><p>" + newCard.description + "</p>";
        cardsContainer.appendChild(cardElement);

        addCardForm.reset();
    });

    addCardForm.addEventListener("reset", function() {
        cardDropdown.selectedIndex = 0; // Reset dropdown selection on form reset
    });

    addCardForm.addEventListener("submit", function(event) {
        event.preventDefault();

        var selectedCardId = cardDropdown.value;
        deleteCard(selectedCardId);
        cardDropdown.selectedIndex = 0; // Reset dropdown selection after deleting

        // Optionally, you can perform additional actions after deleting the card
    });
});



/////////////////////////////////////////////////////////////////////////////////////////////
/* Update card */


document.addEventListener("DOMContentLoaded", function() {
    var addCardForm = document.getElementById("addCardForm");
    var updateCardForm = document.getElementById("updateCardForm");
    var cardsContainer = document.getElementById("cardsContainer");

    addCardForm.addEventListener("submit", function(event) {
        event.preventDefault();

        var titleInput = document.getElementById("newTitle").value;
        var descriptionInput = document.getElementById("newDescription").value;
        var sectionInput = document.getElementById("newSection").value;

        var newCard = {
            title: titleInput,
            description: descriptionInput,
            section: sectionInput
        };

        // Create a new card element and add it to the cards container
        var cardElement = document.createElement("div");
        cardElement.className = "card";
        cardElement.id = "card-" + cardsContainer.childElementCount;
        cardElement.innerHTML = "<h3>" + newCard.title + "</h3><p>" + newCard.description + "</p>";
        cardsContainer.appendChild(cardElement);

        // Clear the form inputs
        addCardForm.reset();
    });

    updateCardForm.addEventListener("Update", function(event) {
        event.preventDefault();

        var updateTitleInput = document.getElementById("updateTitle").value;
        var updateDescriptionInput = document.getElementById("updateDescription").value;
        var updateSectionInput = document.getElementById("updateSection").value;

        var selectedCard = document.querySelector(".card.selected");
        if (selectedCard) {
            var cardTitle = selectedCard.querySelector("h3");
            var cardDescription = selectedCard.querySelector("p");

            cardTitle.textContent = updateTitleInput;
            cardDescription.textContent = updateDescriptionInput;
            // Optionally, update the section as well

            updateCardForm.reset();
        }
    });

    cardsContainer.addEventListener("click", function(event) {
        var clickedCard = event.target.closest(".card");
        if (clickedCard) {
            var selectedCard = cardsContainer.querySelector(".card.selected");
            if (selectedCard) {
                selectedCard.classList.remove("selected");
            }
            clickedCard.classList.add("selected");

            // Populate the update form with the current card's information
            var cardTitle = clickedCard.querySelector("h3").textContent;
            var cardDescription = clickedCard.querySelector("p").textContent;

            document.getElementById("updateTitle").value = cardTitle;
            document.getElementById("updateDescription").value = cardDescription;
        }
    });
});

