$(document).ready(function () {
	CKEDITOR.replace( 'editor',
			{
				toolbar :
				[
					{ name: 'document', items : [ 'NewPage','DocProps','Preview','-','Templates' ] },
					{ name: 'clipboard', items : [ 'Cut','Copy','Paste','-','Undo','Redo' ] },
					{ name: 'editing', items : [ 'Find','Replace','-','SelectAll'] },
					{ name: 'forms', items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button'] },
					{ name: 'links', items : [ 'Link','Unlink','Anchor' ] },
					'/',
					{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
					{ name: 'insert', items : [ 'Image','Flash','Table','HorizontalRule','SpecialChar'] },
					{ name: 'sourcecode', items : [ 'Source' ]},
					'/',
					{ name: 'basicstyles', items : [ 'Bold','Italic','Underline','Subscript','Superscript','-','RemoveFormat' ] },
					{ name: 'styles', items : [ 'Format','Font','FontSize','TextColor','BGColor' ] }
				]
			});
});
