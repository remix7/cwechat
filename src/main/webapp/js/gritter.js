var Gritter = function () {

'use strict';


    $('#add-sticky').click(function () {
        var unique_id = $.gritter.add({
            title: 'This is a sticky notice!',
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" style="color:#ccc">magnis dis parturient</a> montes, nascetur ridiculus mus.',
            image: 'img/avatar-mini.jpg',
            sticky: true,
            time: '',
            class_name: 'my-sticky-class'
        });
        return false;
    });
    $('#add-regular').click(function () {
        $.gritter.add({
            title: 'This is a regular notice!',
            text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" style="color:#ccc">magnis dis parturient</a> montes, nascetur ridiculus mus.',
            image: 'img/avatar-mini.jpg',
            sticky: false,
            time: ''
        });
        return false;
    });
    $('#add-max').click(function () {
        $.gritter.add({
            title: 'This is a notice with a max of 3 on screen at one time!',
            text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" style="color:#ccc">magnis dis parturient</a> montes, nascetur ridiculus mus.',
            image: 'img/avatar-mini.jpg',
            sticky: false,
            before_open: function () {
                if ($('.gritter-item-wrapper').length == 3) {
                    return false;
                }
            }
        });
        return false;
    });
    $('#add-without-image').click(function () {
        $.gritter.add({
            title: 'This is a notice without an image!',
            text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" style="color:#ccc">magnis dis parturient</a> montes, nascetur ridiculus mus.'
        });
        return false;
    });
    $('#add-gritter-light').click(function () {
        $.gritter.add({
            title: 'This is a light notification',
            text: 'Just add a "gritter-light" class_name to your $.gritter.add or globally to $.gritter.options.class_name',
            class_name: 'gritter-light'
        });
        return false;
    });
    $("#remove-all").click(function () {
        $.gritter.removeAll();
        return false;
    });
}();