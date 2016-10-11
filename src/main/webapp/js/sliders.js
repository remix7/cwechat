var Sliders = function () {

'use strict';


    $("#default-slider").slider();
    $("#snap-inc-slider").slider({
        value: 50,
        min: 0,
        max: 1000,
        step: 100,
        slide: function (event, ui) {
            $("#snap-inc-slider-amount").text("$" + ui.value);
        }
    });
    $("#snap-inc-slider-amount").text("$" + $("#snap-inc-slider").slider("value"));
    $("#slider-range").slider({
        range: true,
        min: 0,
        max: 500,
        values: [75, 300],
        slide: function (event, ui) {
            $("#slider-range-amount").text("$" + ui.values[0] + " - $" + ui.values[1]);
        }
    });
    $("#slider-range-amount").text("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1));
    $("#slider-range-max").slider({
        range: "max",
        min: 1,
        max: 10,
        value: 2,
        slide: function (event, ui) {
            $("#slider-range-max-amount").text(ui.value);
        }
    });
    $("#slider-range-max-amount").text($("#slider-range-max").slider("value"));
    $("#slider-range-min").slider({
        range: "min",
        value: 37,
        min: 1,
        max: 700,
        slide: function (event, ui) {
            $("#slider-range-min-amount").text("$" + ui.value);
        }
    });
    $("#slider-range-min-amount").text("$" + $("#slider-range-min").slider("value"));
    $("#eq > span").each(function () {
        var value = parseInt($(this).text(), 10);
        $(this).empty().slider({
            value: value,
            range: "min",
            animate: true,
            orientation: "vertical"
        });
    });
    var select = $("#minbeds");
    var slider = $("<div id='slider'></div>").insertAfter(select).slider({
        min: 1,
        max: 6,
        range: "min",
        value: select[0].selectedIndex + 1,
        slide: function (event, ui) {
            select[0].selectedIndex = ui.value - 1;
        }
    });
    $("#minbeds").change(function () {
        slider.slider("value", this.selectedIndex + 1);
    });
    $("#slider-vertical").slider({
        orientation: "vertical",
        range: "min",
        min: 0,
        max: 100,
        value: 60,
        slide: function (event, ui) {
            $("#slider-vertical-amount").text(ui.value);
        }
    });
    $("#slider-vertical-amount").text($("#slider-vertical").slider("value"));
    $("#slider-range-vertical").slider({
        orientation: "vertical",
        range: true,
        values: [17, 67],
        slide: function (event, ui) {
            $("#slider-range-vertical-amount").text("$" + ui.values[0] + " - $" + ui.values[1]);
        }
    });
    $("#slider-range-vertical-amount").text("$" + $("#slider-range-vertical").slider("values", 0) + " - $" + $("#slider-range-vertical").slider("values", 1));
}();