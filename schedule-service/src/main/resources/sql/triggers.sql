CREATE OR REPLACE FUNCTION update_teacher_subject()
    RETURNS TRIGGER AS $$
BEGIN
    UPDATE teacher
    SET item_name = NEW.subject_name
    WHERE item_name = OLD.subject_name;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_teacher_subject_trigger
    AFTER UPDATE ON subject
    FOR EACH ROW
EXECUTE FUNCTION update_teacher_subject();
