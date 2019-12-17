--This query to select all articles commensts with the data that which comment has voted 
--current logged user
SELECT 
    users.user_name,
    users.user_first_name,
    users.user_last_name,
    articles_comments.comment_content,
    articles_comments.article_id_comment,
    articles_comments.comment_id,
    articles_comments_votes.vote_articles_comments_id,
    articles_comments_votes.vote_user_id,
    articles_comments_votes.vote_value
FROM
	users 
INNER JOIN
    articles_comments ON articles_comments.user_id = users.user_id
    AND
    articles_comments.article_id_comment = 9
LEFT JOIN
	articles_comments_votes  
    ON articles_comments.comment_id = articles_comments_votes.vote_articles_comments_id 
    AND articles_comments_votes.vote_user_id = 1
    ORDER BY articles_comments.comment_id DESC
