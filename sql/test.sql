select hand_soft, hand_hard, house, action, SUM(profit)
from poker.blackjack
where action != 'SPLIT'
group by hand_soft, hand_hard, house, action
order by hand_hard desc;