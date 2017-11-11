import praw
import prawcore
import config

_file_name = "reddit_data.dat"

print("Initializing bot...")

def bot_login():
    print("Authenticating bot...")
    return praw.Reddit(client_id=config.client_id,
                     client_secret=config.client_secret,
                     username=config.username,
                     password=config.password,
                     user_agent="Created by: /u/memphoyles - Send post information to a desktop application. *Personal use*")

def get_submissions(subreddit, type_sort="hot", limit=10):
    return [p for p in (subreddit.hot(limit=limit) if type_sort=="hot" else 
           (subreddit.top(limit=limit) if type_sort=="top" else 
           (subreddit.new(limit=limit) if type_sort=="new" else 
           subreddit.rising(limit=limit))))]

def get_subreddit(reddit, subreddit_name):
    return reddit.subreddit(subreddit_name)

reddit = bot_login()

list_subs = ["brasil", "worldnews"]

with open(_file_name, "w") as file:
    for sub in list_subs:
        
        file.write("SUBREDDIT:" + sub + "\n")

        sub_object = get_subreddit(reddit, sub)
        sub_limit = 5
        type_sort = "hot"
        sub_posts = get_submissions(sub_object, type_sort=type_sort, limit=sub_limit)

        for p in sub_posts:
            file.write("|".join([p.title, p.url, p.shortlink]) + "\n")


print("Finalizing bot...")