(function($) {

    $.fn.TruncExpandText = function(options) {
        var defaultVals = {
            maxLength: 500,
            setLength: 500,
            heightOfContainer: '108px',
            text: 'more...'
        };

        return this.each(function() {
            TruncateTextForTextareaAndAttachMoreEventToExpand($(this), $.extend({}, defaultVals, options));
        });
    }

})(jQuery);

function TruncateTextForTextareaAndAttachMoreEventToExpand($item, defaultVals) {
    if (defaultVals == null) {
        defaultVals = {
            maxLength: 1000,
            setLength: 1000,
            heightOfContainer: '220px',
            text: '...'
        };
    }
    return $item.each(function() {
        //Cut long text and add more...
        $(this).each(function() {
            var $me = $(this);
            var $newOne = $(this).clone().addClass('crm_more');
            $(this).after($newOne);
            $(this).remove();
            if ($newOne.val().length > defaultVals.maxLength) {
                var val = $(this).val();
                $newOne.val(val.substring(0, defaultVals.setLength)).css({ height: defaultVals.heightOfContainer }).after('<span class="crm_more_trigger">' + defaultVals.text + '</span>').next().click(function() {
                    $(this).prev().val(val);
                    var $parent = $(this).prev();
                    $parent.autogrow({ expandTolerance: 1 });
                    $(this).remove();
                }).attr({ title: 'Click to see all the comments' }).css({ cursor: 'pointer' });
            }
        });
    });
} 