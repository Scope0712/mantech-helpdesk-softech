<%-- 
    Document   : newjsp
    Created on : Oct 31, 2011, 9:24:53 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript"  src="../ckeditor/ckeditor.js" language="javascript"></script>
        <script type="text/javascript" src="../ckfinder/ckfinder.js" language="javascript"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <textarea id="noidung" name="noidung" rows="30" cols="80"></textarea>
    <script type="text/javascript">
        // This is a check for the CKEditor class. If not defined, the paths must be checked.
        if ( typeof CKEDITOR == 'undefined' )
        {
            document.write(
            '<strong><span style="color: #ff0000">Error</span>: CKEditor not found</strong>.' +
                'This sample assumes that CKEditor (not included with CKFinder) is installed in' +
                'the "/ckeditor/" path. If you have it installed in a different place, just edit' +
                'this file, changing the wrong paths in the &lt;head&gt; (line 5) and the "BasePath"' +
                'value (line 32).' ) ;
        }
        else
        {
            var editor = CKEDITOR.replace( 'noidung' );
            editor.setData( '' );

            // Just call CKFinder.SetupCKEditor and pass the CKEditor instance as the first argument.
            // The second parameter (optional), is the path for the CKFinder installation (default = "/ckfinder/").
            CKFinder.setupCKEditor( editor, '/MantechHelpdesk-war/ckfinder/' ) ;
            //CKFinder.SetupCKEditor( editor, { BasePath : '../../', RememberLastFolder : false } ) ;
            // It is also possible to pass an object with selected CKFinder properties as a second argument.
            // CKFinder.SetupCKEditor( editor, { BasePath : '../../', RememberLastFolder : false } ) ;
        }

    </script>
</body>
</html>
