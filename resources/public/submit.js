(function() {
  var forgeryToken = document.getElementById('__anti-forgery-token');
  var outputArea = document.getElementById('md-target');
  var editor = ace.edit("editor");
  editor.setTheme("ace/theme/xcode");
  editor.getSession().setMode("ace/mode/markdown");

  editor.addEventListener('input', function(e) {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
      if (request.readyState === 4 && request.status === 200) {
          outputArea.innerHTML = request.responseText;
        }
    }
    request.open('POST', '/', true);
    request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    var textValue = editor.getValue();
    var forgeryValue = forgeryToken.value;
    var data = 'text=' + encodeURIComponent(textValue) + '&' + '__anti-forgery-token=' + encodeURIComponent(forgeryValue);
    request.send(data);
  });
})();
