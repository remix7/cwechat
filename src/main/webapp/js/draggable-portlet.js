var DraggablePortlet = function () {

'use strict';

    return {
        init: function () {
            if (!jQuery().sortable) {
                return;
            }
            $("#draggable_portlets").sortable({
                connectWith: ".panel",
                items: ".panel",
                opacity: 0.8,
                coneHelperSize: true,
                placeholder: 'sortable-box-placeholder round-all',
                forcePlaceholderSize: true,
                tolerance: "pointer"
            });
            $(".column").disableSelection();
        }
    };
}();