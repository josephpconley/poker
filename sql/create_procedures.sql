CREATE OR REPLACE FUNCTION process_hands() RETURNS VOID
AS $$
DECLARE
	i INTEGER;
	p INTEGER;
	
	j INTEGER := 1;
	handArray VARCHAR[];
	handStr VARCHAR;
	handType VARCHAR;
	
	s RECORD;
	h RECORD;
BEGIN
	FOR s IN SELECT * FROM poker.bj_showdown WHERE hand_processed is false LOOP
		
		FOR h IN SELECT * FROM poker.bj_hand WHERE show_id = s.SHOW_ID ORDER BY hand_id LOOP
			
			FOR i IN REVERSE char_length(h.decision)..1 LOOP			
				
				INSERT INTO poker.bj_result(show_id,
								hand_id,
								hand_type,
								decision,
								house,
								profit)
				VALUES(h.show_id,
					     h.hand_id,
					     get_hand_type(h.show_id, h.hand_id, i),
					     substring(h.decision for i),
					     h.house,
					     h.profit);								
			END LOOP;
			
			/*
			--handle splits
			FOR i IN 1..char_length(h.decision) LOOP
				IF substr(h.decision,i,1) = 'P' THEN
					p := p + 1;
				ELSE
					splitArray[j] := substr(h.decision,i,1);
					j := j + 1;
				END IF;
			END LOOP;
			*/
		END LOOP;
		/*		
		UPDATE poker.bj_showdown
		SET hand_processed = true
		where show_id = s.show_id;
		*/
	END LOOP;
END;
$$ LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION get_hand_type(showId INTEGER, handId INTEGER, n INTEGER) RETURNS VARCHAR
AS $$
DECLARE
	handArray VARCHAR[];
	handType VARCHAR(5);
	handStr VARCHAR;
	
	h RECORD;
	
	i INTEGER;
	handHard INTEGER;
BEGIN
	SELECT * INTO h FROM poker.bj_hand WHERE show_id = showId AND hand_id = handId;
	handArray := string_to_array(h.hand,',');
	handHard := CAST h.hand_hard AS INTEGER;
	
	FOR i IN REVERSE array_upper(handArray, 1)..n LOOP
		IF handArray[i] = 'A' THEN
			handHard := handHard - 11;
		ELSE
			handHard := handHard - (CAST handArray[i] AS INTEGER);
		END IF;
		
		handArray[i] := null;
	END LOOP;
	
	raise notice '%', handHard;
	handStr := array_to_string(handArray, ',');
		
	/*
	IF array_upper(handArray, 1) = 2 THEN
		IF handArray[1] = handArray[2] THEN
			handType := handStr;
		ELSIF h.hand_soft IS NOT NULL THEN
			handType := h.hand_soft;
		END IF;
	ELSE
		handType := h.hand_hard;
	END IF;	
	*/
	
	RETURN handStr;
END;
$$ LANGUAGE 'plpgsql'; 

CREATE OR REPLACE FUNCTION get_hard_hand(showId INTEGER, handId INTEGER, n INTEGER) RETURNS VARCHAR
AS $$
DECLARE
	handArray VARCHAR[];
	hardValue INTEGER := 0;
	
	i INTEGER;
BEGIN
	handArray := string_to_array(h.hand,',');
	FOR i IN 1..array_upper(handArray,',') LOOP
		IF handArray
	END LOOP
END;
$$ LANGUAGE 'plpgsql';
