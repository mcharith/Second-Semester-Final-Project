$(document).ready(function () {
    $(".bus_container, .route_container, .schedule_container,.personal-details-container").hide();

    $("a[href='#home']").click(function () {
        $(".home_container").fadeIn();
        $(".route_container").hide();
        $(".schedule_container").hide();
        $(".bus_container").hide();
        $(".personal-details-container").hide();
    });

    // Function to show buses section
    $("a[href='#buses']").click(function () {
        $(".home_container").hide();
        $(".route_container").hide();
        $(".schedule_container").hide();
        $(".personal-details-container").hide();
        $(".bus_container").fadeIn();
    });

    // Function to show routes section
    $("a[href='#routes']").click(function () {
        $(".home_container").hide();
        $(".bus_container").hide();
        $(".schedule_container").hide();
        $(".personal-details-container").hide();
        $(".route_container").fadeIn();
    });

    $("a[href='#schedule']").click(function (){
        $(".home_container").hide();
        $(".bus_container").hide();
        $(".route_container").hide();
        $(".personal-details-container").hide();
        $(".schedule_container").fadeIn();
    })

    $("a[href='#personalDetails']").click(function (){
        $(".home_container").hide();
        $(".bus_container").hide();
        $(".route_container").hide();
        $(".personal-details-container").fadeIn();
        $(".schedule_container").hide();
    })
});