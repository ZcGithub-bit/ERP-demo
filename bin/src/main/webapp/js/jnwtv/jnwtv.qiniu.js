
var QiniuUploaderFactory = {
		
	build : function( cfg ){
		var uploader = Qiniu.uploader({
		    runtimes: 'html5,flash,html4',
		    browse_button: cfg.browseButton ,
		    drop_element: cfg.dropElement == null ? "" : cfg.dropElement,
		    max_file_size: '120mb',
		    //flash_swf_url: 'js/plupload/Moxie.swf',
		    dragdrop: cfg.dragdrop == null ? true : cfg.dragdrop , // true
		    chunk_size: '4mb',
		    uptoken_url: /*cfg.uptokenUrl ,*/ 'getQiniuToken',
		    domain: cfg.domain == null ? 'jnwtv01' : cfg.domain, // 'jnwtv01'
		    auto_start: cfg.autoStart == null ? true : cfg.autoStart , // true
		    unique_names:cfg.uniqueNames == null ? false : cfg.uniqueNames , // false
		    save_key:cfg.saveKey == null ? false : cfg.saveKey ,
		    init: {
		        'FilesAdded': 		cfg.filesAddedHandler 		== null ? function(up,files){} 			: cfg.filesAddedHandler ,
		        'BeforeUpload': 	cfg.beforeUploadHandler 	== null ? function(up, file){} 			: cfg.beforeUploadHandler,
		        'UploadProgress': 	cfg.uploadProgressHandler 	== null ? function(up, file){} 			: cfg.uploadProgressHandler ,
		        'UploadComplete': 	cfg.uploadCompleteHandler	== null ? function(){} 					: cfg.uploadCompleteHandler ,
		        'FileUploaded': 	cfg.fileUploadedHandler 		== null ? function(up, file, info){} 	: cfg.fileUploadedHandler,
		        'Error': 			cfg.errorHandler 			== null ? function(up, err, errTip){} 	: cfg.errorHandler ,
		        'Key': 				cfg.keyHandler 				== null ? function(up,file){} 			: cfg.keyHandler 
		    }
		});
		return uploader ;
	}
		
} ;




