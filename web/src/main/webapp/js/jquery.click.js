/**
 * 
 */
function sendForm(sRef) {
					document.send.idPlay.value = sRef;
					document.send.submit();
				}

var ns6 = document.getElementById && !document.all ? 1 : 0
	var head = "display:''"
	var folder = ''
	function expandit(curobj) {
		folder = ns6 ? curobj.nextSibling.nextSibling.style
				: document.all[curobj.sourceIndex + 1].style
		if (folder.display == "none")
			folder.display = ""
		else
			folder.display = "none"
	}