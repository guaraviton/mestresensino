app.dialog = function(options) {
	
	DIALOG_CLASS_TXT = '';
	DIALOG_STYLE_TXT = 'float:left; margin:4px 5px 6px 0;';
	
	switch(options.tipoDialog) {
	    case app.DIALOG_CHECK:
	    	DIALOG_CLASS_TXT =  'ui-icon ui-icon-circle-check';
	        break;
	    case app.DIALOG_INFO:
	    	DIALOG_CLASS_TXT =  'ui-icon ui-icon-info';
	        break;
	    case app.DIALOG_ERROR:
	    	DIALOG_CLASS_TXT =  'ui-icon ui-icon-circle-close';
	        break;
	}
	
	$('<div id="'+options.id+'"></div>').html('<span class="'+DIALOG_CLASS_TXT+'" style="'+DIALOG_STYLE_TXT+'"></span>'+options.mensagem).dialog({
      modal: true,
      title: options.title ? options.title : 'Atenção',
      width:'auto',
      height:'auto',
      minHeight: 'auto',
      resizable: false,
      buttons: options.buttons,
      create: function( event, ui ) {
    	  $(this).css("maxWidth", "700px");
      }
	});
};

app.closeDialog = function(id) {
	$('#'+id).dialog('destroy').remove();
};