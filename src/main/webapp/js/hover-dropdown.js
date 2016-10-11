;
(function ($, window, undefined) {

'use strict';

    var $allDropdowns = $();
    $.fn.dropdownHover = function (options) {
        $allDropdowns = $allDropdowns.add(this.parent());
        return this.each(function () {
            var $this = $(this),
                $parent = $this.parent(),
                defaults = {
                    delay: 500,
                    instantlyCloseOthers: true
                },
                data = {
                    delay: $(this).data('delay'),
                    instantlyCloseOthers: $(this).data('close-others')
                },
                settings = $.extend(true, {}, defaults, options, data),
                timeout;
            $parent.hover(function (event) {
                if (!$parent.hasClass('open') && !$this.is(event.target)) {
                    return true;
                }
                if (shouldHover) {
                    if (settings.instantlyCloseOthers === true)
                        $allDropdowns.removeClass('open');
                    window.clearTimeout(timeout);
                    $parent.addClass('open');
                }
            }, function () {
                if (shouldHover) {
                    timeout = window.setTimeout(function () {
                        $parent.removeClass('open');
                    }, settings.delay);
                }
            });
            $this.hover(function () {
                if (shouldHover) {
                    if (settings.instantlyCloseOthers === true)
                        $allDropdowns.removeClass('open');
                    window.clearTimeout(timeout);
                    $parent.addClass('open');
                }
            });
            $parent.find('.dropdown-submenu').each(function () {
                var $this = $(this);
                var subTimeout;
                $this.hover(function () {
                    if (shouldHover) {
                        window.clearTimeout(subTimeout);
                        $this.children('.dropdown-menu').show();
                        $this.siblings().children('.dropdown-menu').hide();
                    }
                }, function () {
                    var $submenu = $this.children('.dropdown-menu');
                    if (shouldHover) {
                        subTimeout = window.setTimeout(function () {
                            $submenu.hide();
                        }, settings.delay);
                    } else {
                        $submenu.hide();
                    }
                });
            });
        });
    };
    var shouldHover = false,
        mouse_info = {
            hits: 0,
            x: null,
            y: null
        };
    $(document).ready(function () {
        $('[data-hover="dropdown"]').dropdownHover();
        $(document).mousemove(function (e) {
            mouse_info.hits++;
            if (mouse_info.hits > 20 || (Math.abs(e.pageX - mouse_info.x) + Math.abs(e.pageY - mouse_info.y)) < 4) {
                $(this).unbind(e);
                shouldHover = true;
            } else {
                mouse_info.x = e.pageX;
                mouse_info.y = e.pageY;
            }
        });
    });
    var css = '.dropdown-submenu:hover>.dropdown-menu{display:none}';
    var style = document.createElement('style');
    style.type = 'text/css';
    if (style.styleSheet) {
        style.styleSheet.cssText = css;
    } else {
        style.appendChild(document.createTextNode(css));
    }
    $('head')[0].appendChild(style);
})(jQuery, this);