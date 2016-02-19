(function($, window) {
    $.fn.loginPopup = function($popup) {
        var $self = this,
            $window = $(window);

        return this.toggle(
            function() {
                $popup.show().bind('click.bLogin', function(event){
                    // предотвращаем всплытие события,
                    // т.е. не даем закрыться попапу(см.ниже)
                    event.stopPropagation();
                });
                // скрываем попап если:
                $window.bind('click.bLogin', function(){
                    // до window "прошел" click
                    $self.trigger('click');
                }).bind('keydown.bLogin', function(event){
                        // нажали Escape
                        if(event.keyCode === 27){
                            $self.trigger('click')
                        }
                    });
                return false;
            },
            function(){
                // прячем попап
                $popup.hide().unbind('.bLogin');
                $window.unbind('.bLogin');
                return false;
            }
        );
    };
})(jQuery, window);

