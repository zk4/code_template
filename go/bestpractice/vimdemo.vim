function! Strip(input_string)
    return substitute(a:input_string, '^\s*\(.\{-}\)\s*$', '\1', '')
endfunction

if Strip("  https://") =~ "^http"
	echom "in"
else
	echo "not in"
endif
