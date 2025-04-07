// Get bus Count
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/v1/journeyPass/bus/count",
        type: "GET",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("authToken"),
            "Content-Type": "application/json"
        },
        success: function (response) {
            $("#homeBusCount").text(response);
        },
        error: function (xhr, status, error) {
            console.error("Error fetching bus count:", error);
            $("#homeBusCount").text("Error");
        }
    });
});

// Get route Count
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/v1/JourneyPass/route/count",
        type: "GET",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("authToken"),
            "Content-Type": "application/json"
        },
        success: function (response) {
            $("#homeRouteCount").text(response);
        },
        error: function (xhr, status, error) {
            console.error("Error fetching route count:", error);
            $("#homeBusCount").text("Error");
        }
    });
});

// Get schedule Count
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/v1/JourneyPass/schedule/count", // API Endpoint
        type: "GET",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("authToken"),
            "Content-Type": "application/json"
        },
        success: function (response) {
            $("#homeSchedulesCount").text(response); // Update h2 with the bus count
        },
        error: function (xhr, status, error) {
            console.error("Error fetching schedule count:", error);
            $("#homeSchedulesCount").text("Error"); // Display error message if request fails
        }
    });
});