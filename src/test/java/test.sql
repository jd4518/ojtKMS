	SELECT *
	  	FROM (	SELECT inner_table.* , @rownum:=@rownum+1 AS row_seq
	  					FROM		(	SELECT no , id
											FROM test
										
											ORDER BY no ) inner_table , (SELECT @rownum:=0) R
						WHERE @rownum <= 50 ) S
		WHERE row_seq BETWEEN 21 AND 30;